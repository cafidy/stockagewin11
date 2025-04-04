import numpy as np
import time

vec = np.arange(15, 35)
print(vec[1:-1])

# Exercice 2
def create_random_array(n, m, a):
    return np.random.randint(-a, a, (n, m))
n = 1_000_000

# 1ère méthode (sans NumPy)
start_time = time.time()
L = list(range(1, n+1))
somme = sum(L)
end_time = time.time()
print(f"Somme sans NumPy: {somme}, Temps: {end_time - start_time:.5f} sec")

# 2ème méthode (avec NumPy)
start_time = time.time()
arr = np.arange(1, n+1)
somme_numpy = np.sum(arr)
end_time = time.time()
print(f"Somme avec NumPy: {somme_numpy}, Temps: {end_time - start_time:.5f} sec")

# Exercice 4
def interleave_matrices(A, B, C):
    if A.shape != B.shape or A.shape != C.shape:
        raise ValueError("Les matrices doivent avoir la même taille")
    return np.vstack((A, B, C)).reshape(-1, A.shape[1])

# Exercice 5
def clip_values_loop(A):
    B = A.copy()
    for i in range(B.shape[0]):
        for j in range(B.shape[1]):
            if B[i, j] < 0:
                B[i, j] = 0
            elif B[i, j] > 1:
                B[i, j] = 1
    return B

def clip_values_numpy(A):
    B = A.copy()
    B[B < 0] = 0
    B[B > 1] = 1
    return B

# Mesure du temps
A = np.random.uniform(-2, 3, (10000, 10000))
t0 = time.perf_counter()
B_loop = clip_values_loop(A)
t1 = time.perf_counter()
B_numpy = clip_values_numpy(A)
t2 = time.perf_counter()
print(f"Temps boucle: {t1 - t0:.5f} sec, Temps NumPy: {t2 - t1:.5f} sec")

# Exercice 6
def abs_loop(A):
    B = A.copy()
    for i in range(B.shape[0]):
        for j in range(B.shape[1]):
            B[i, j] = abs(B[i, j])
    return B

def abs_numpy(A):
    return np.abs(A)

# Exercice 7
def identical_percentage_loop(A, B):
    count = 0
    total = A.size
    for i in range(A.shape[0]):
        for j in range(A.shape[1]):
            if A[i, j] == B[i, j]:
                count += 1
    return (count / total) * 100

def identical_percentage_numpy(A, B):
    return np.mean(A == B) * 100

# Exercice 8
def normalize_loop(A):
    B = A.copy()
    for i in range(A.shape[0]):
        mean = np.mean(A[i])
        std = np.std(A[i])
        for j in range(A.shape[1]):
            B[i, j] = (A[i, j] - mean) / std
    return B

def normalize_numpy(A):
    mean = np.mean(A, axis=1, keepdims=True)
    std = np.std(A, axis=1, keepdims=True)
    return (A - mean) / std

# Exercice 9
def mean_even_odd_loop(A):
    even_sum, even_count = 0, 0
    odd_sum, odd_count = 0, 0
    for val in A:
        if val % 2 == 0:
            even_sum += val
            even_count += 1
        else:
            odd_sum += val
            odd_count += 1
    return (even_sum / even_count if even_count else 0,
            odd_sum / odd_count if odd_count else 0)

def mean_even_odd_numpy(A):
    evens = A[A % 2 == 0]
    odds = A[A % 2 == 1]
    return (np.mean(evens) if evens.size > 0 else 0,
            np.mean(odds) if odds.size > 0 else 0)

# Test rapide
A = np.random.randint(-10, 10, (1000, 1000))
B = np.random.randint(-10, 10, (1000, 1000))
print("Pourcentage de valeurs identiques (boucle):", identical_percentage_loop(A, B))
print("Pourcentage de valeurs identiques (numpy):", identical_percentage_numpy(A, B))