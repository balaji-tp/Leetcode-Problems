n = int(input())
for _ in range(n):
    w = input()
    wl = len(w)
    
    print(f"{w[0]}{wl-2}{w[-1]}" if wl > 10 else w)