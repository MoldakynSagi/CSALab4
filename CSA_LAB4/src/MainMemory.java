public class MainMemory {
    public Color[][] memory;
    public String[] cache = null;
    public double hit = 0;
    public double miss = 0;

    public void create(int N, int M, int K) {
        memory = new Color[N][M];
        cache = new String[K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                memory[i][j] = new Color();
                memory[i][j].c = Integer.toString(i) + Integer.toString(j) + 'c';
                memory[i][j].m = Integer.toString(i) + Integer.toString(j) + 'm';
                memory[i][j].y = Integer.toString(i) + Integer.toString(j) + 'y';
                memory[i][j].k = Integer.toString(i) + Integer.toString(j) + 'k';
            }
        }
    }

    public void result() {
        System.out.println("Total number of accesses: " + (hit + miss));
        System.out.println("Hits: " + hit);
        System.out.println("Misses: " + miss);
        System.out.println("Hit rate "  + hit/(hit + miss) );
        System.out.println("Miss rate " + miss/(hit + miss) );
    }

    public void firstAlgorithm(int N, int M, int K) {
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int k = 0; k < 4; k++) {
                    if (k == 0) {
                        if (cache[index] == memory[i][j].c) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, i, j, k, N, M, K);
                        }
                    }

                    if (k == 1) {
                        if (cache[index] == memory[i][j].m) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, i, j, k, N, M, K);
                        }
                    }

                    if (k == 2) {
                        if (cache[index] == memory[i][j].y) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, i, j, k, N, M, K);
                        }
                    }

                    if (k == 3) {
                        if (cache[index] == memory[i][j].k) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, i, j, k, N, M, K);
                        }
                    }

                    index++;
                    if(index == K) {
                        index = 0;
                    }
                }
            }
        }
    }

    public void secondAlgorithm(int N, int M, int K) {
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int k = 0; k < 4; k++) {
                    if (k == 0) {
                        if (cache[index] == memory[j][i].c) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, j, i, k, N, M, K);
                        }
                    }

                    if (k == 1) {
                        if (cache[index] == memory[j][i].m) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, j, i, k, N, M, K);
                        }
                    }

                    if (k == 2) {
                        if (cache[index] == memory[j][i].y) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, j, i, k, N, M, K);
                        }
                    }

                    if (k == 3) {
                        if (cache[index] == memory[j][i].k) {
                            hit++;
                        } else {
                            miss++;
                            cache(index, j, i, k, N, M, K);
                        }
                    }

                    index++;
                    if(index == K) {
                        index = 0;
                    }
                }
            }
        }

    }

    public void cache(int index, int x, int y, int colorPos, int N, int M, int K) {
        while (index < K) {
            if (colorPos == 0) {
                cache[index++] = memory[x][y].c;
                colorPos++;
            }
            if (colorPos == 1) {
                cache[index++] = memory[x][y].m;
                colorPos++;
            }
            if (colorPos == 2) {
                cache[index++] = memory[x][y].y;
                colorPos++;
            }
            if (colorPos == 3) {
                cache[index++] = memory[x][y].k;
                colorPos++;
            }

            if (colorPos == 4) {
                colorPos = 0;
                y++;
            }

            if(y == M){
                y = 0;
                x++;
            }

            if(x == N){
                x = 0;
            }
        }
    }

}
