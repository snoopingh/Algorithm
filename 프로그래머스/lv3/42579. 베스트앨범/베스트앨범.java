import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        ArrayList<Item> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            List<Item> compare = new ArrayList<>();
            String genre = list.get(i).getKey();

            for (int j = 0; j < genres.length; j++) {
                if (genres[j].equals(genre)) {
                    compare.add(new Item(j, plays[j]));
                }
            }

            Collections.sort(compare, (o1, o2) -> o2.getPlays() - o1.getPlays());

            result.add(compare.get(0));
            if (compare.size() != 1) {
                result.add(compare.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).getId();
        }

        return answer;
    }
}

class Item {
    private int id;
    private int plays;

    public Item(int id, int plays) {
        this.id = id;
        this.plays = plays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }
}