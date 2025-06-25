#include <stdio.h>

void solve(int n, char src, char helper, char dest) {
  if (n == 1) {
    printf("Transferring from %c to %c\n", src, dest);
    return;
  }

  solve(n - 1, src, dest, helper);
  printf("Transferring from %c to %c\n", src, dest);
  solve(n - 1, helper, src, dest);
}

int main() {
  solve(3, 'A', 'B', 'C');
  return 0;
}
