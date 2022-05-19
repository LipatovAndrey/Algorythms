import java.io.*;
import java.util.*;

/*
Принцип работы

индекс представляет собой HashMap где ключом является слово,
а значением второй HashMap где ключом является номер документа, а значением количество вхождений слова
сначала вычитываем документы и заполняем по ним индекс, затем когда приходит запрос каждое слово запроса
перекладываем в сет, для того чтобы слова запроса были уникальными, затем итерируемся по множеству уникальных слов и
для каждого слова ишем значение в индексе. найденные значения суммируем в HashMap где ключом является номер документа,
а значением число вхождений слов запроса. Полученый результат сортируем по значению и в случае равенства значений по ключу.

Временная сложность
для создания индекса требуется совершить n операций для вставки значений для каждого слова - О(n)
для каждого слова в запросе необходимо получить значение из hashMap
для этого рассчитывается индекс элемента при помощи хешфункции за константное время О(1)
затем для получения вхождений слова в документ по номеру документа так же получаем за константное время О(1)
соответственно временная сложность для получения релевантности документов будет составлять О(n)
так как необходимо совершить n - по количеству слов константных операций
соответственно суммарная временная сложность O(n)

Пространственная сложность
Для индекса необходимо для каждого слова сохранить ключ, а для каждого ключа количество вхождений в документ
следовательно будет потребляться памяти n * m
значит потребление памяти будет расти О(n2)
https://contest.yandex.ru/contest/24414/run-report/66861037/
*/
public class SearchSystemSolution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            Map<String, Map<Integer, Integer>> wordsIndex = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    if (!wordsIndex.containsKey(word)) {
                        Map<Integer, Integer> entries = new HashMap<>();
                        entries.put(i, 1);
                        wordsIndex.put(word, entries);
                    } else {
                        Map<Integer, Integer> entries = wordsIndex.get(word);
                        if (!entries.containsKey(i)) {
                            entries.put(i, 1);
                        } else {
                            entries.put(i, entries.get(i) + 1);
                        }
                    }
                }
            }

            int m = Integer.parseInt(reader.readLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                Map<Integer, Integer> relevationRate = new HashMap<>();
                Set<String> uniqueWords = new HashSet<>();
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    uniqueWords.add(word);
                }

                for (String word : uniqueWords) {
                    if (wordsIndex.containsKey(word)) {
                        Map<Integer, Integer> numberOfEntries = wordsIndex.get(word);

                        for (Integer documentNumber : numberOfEntries.keySet()) {
                            if (!relevationRate.containsKey(documentNumber)) {
                                relevationRate.put(documentNumber, numberOfEntries.get(documentNumber));
                            } else {
                                relevationRate.put(documentNumber, relevationRate.get(documentNumber) + numberOfEntries.get(documentNumber));
                            }
                        }
                    }
                }

                StringBuffer buffer = new StringBuffer();
                relevationRate
                        .entrySet()
                        .stream()
                        .sorted((o1, o2) -> {
                            if (o1.getValue() == o2.getValue()) {
                                return o1.getKey().compareTo(o2.getKey());
                            }
                            return o2.getValue().compareTo(o1.getValue());
                        })
                        .limit(5)
                        .forEach(entry -> {
                            buffer.append(entry.getKey() + 1);
                            buffer.append(" ");
                        });
                writer.write(buffer.toString().trim());
                writer.newLine();
            }
            writer.flush();
        }
    }
}
