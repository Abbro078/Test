import java.util.*;
import java.lang.*;
import java.io.*;


public class Main
{

    public static class ListOfStrings {

        private String[] items;
        private int N;

        public ListOfStrings() {
            items = new String[4];
            N = 0;
        }

        private void resize(int capacity) {
            String[] temp = new String[capacity];
            for (int i = 0; i < N; i++)
                temp[i] = items[i];
            items = temp;
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public void add(String item) {
            if (item == null)
                throw new IllegalArgumentException();
            if (N == items.length)
                resize(2 * items.length);
            items[N++] = item;
        }

        public String remove() {
            if (N == 0)
                throw new NoSuchElementException();
            String v = items[N - 1];
            items[N - 1] = null;
            N--;
            if (N > 4 && N == items.length / 4)
                resize(items.length / 2);
            return v;
        }

        public String get(int position) {
            if (position < 0 || position >= N)
                throw new NoSuchElementException();
            return items[position];
        }

        public int position(String item) {
            if (item == null)
                throw new IllegalArgumentException();
            for (int i = 0; i < N; i++)
                if (items[i].equals(item))
                    return i;
            return -1;
        }

        public void add(String item, int position) {
            if (item == null)
                throw new IllegalArgumentException();
            if (position < 0 || position > N)
                throw new NoSuchElementException();

            if (N == items.length)
                resize(2 * items.length);

            for (int i = N; i > position; i--) {
                items[i] = items[i - 1];
            }

            items[position] = item;
            N++;
        }

        public String remove(int position) {
            if (position < 0 || position >= N)
                throw new NoSuchElementException();

            String removedItem = items[position];

            for (int i = position; i < N - 1; i++) {
                items[i] = items[i + 1];
            }

            items[N - 1] = null;
            N--;

            if (N > 4 && N == items.length / 4)
                resize(items.length / 2);

            return removedItem;
        }
    }
//123123123123123123123213123123123
    //i love dicks
    //1238912890312938
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int totalCombinations = (int) Math.pow(k, n);

        for (int i = 0; i < totalCombinations; i++) {
            StringBuilder sb = new StringBuilder();
            int temp = i;

            for (int j = 0; j < n; j++) {
                int digit = temp % k;
                sb.append(digit).append(" ");
                temp /= k;
            }

            System.out.println(sb);
        }
    }
//12378t612oghij312oghi3123hjkb123ghiko123hijkbg123klghu123lghiju123oghiu
}