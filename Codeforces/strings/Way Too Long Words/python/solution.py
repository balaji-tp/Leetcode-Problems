
n = int(input())
for _ in range(n):
    w = input()
    wl = len(w)
    if wl > 10:
        print(f"{w[0]}{wl-2}{w[-1]}")
    else:
        print(w)