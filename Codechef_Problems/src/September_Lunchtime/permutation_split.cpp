#include <bits/stdc++.h>

using namespace std;

const int MAX_N = 105;

int p[MAX_N], deg[MAX_N];
bool dp[MAX_N][MAX_N * MAX_N];

int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        scanf("%d", &n);
        for (int i = 1; i <= n; i++) {
            scanf("%d", &p[i]);
            deg[i] = 0;
        }
        int target = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i < j && p[i] > p[j]) ||
                    (i > j && p[i] < p[j]))
                {
                    deg[i]++;
                    target++;
                }
            }
        }
        target /= 2;
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= target; s++) {
                dp[i][s] = dp[i - 1][s];
                if (s >= deg[i])
                    dp[i][s] |= dp[i - 1][s - deg[i]];
            }
        }
        puts(dp[n][target] ? "YES" : "NO");
    }
    return 0;
}
