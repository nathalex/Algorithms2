import math

""" C(i, j) represents the cost of matching the first i features in the left
image with the first j features in the right image and c(z1i,z2j) is the cost of
matching the two features z1i , z2j as shown in Equation (6)"""
"""
def delta(i):
    try:
        i
    except NameError:
        return 0
    else:
        return 1

def c(i,j):
    return((1 - delta(i)) * ((1/2) * (z(i) - z(j))/S(s) * (z(i) - z(j))))#don't collect (z(i) - z(j)) as terms


Occlusion = (math.log1p((PDs/(1 - PDs))(1/(math.pow(|( math.pow((2 * math.pi), d) * math.pow(S(s),(-1))|,(1/2)))))
 N and M measurements in each of the two epipolar scanlines, respectively"""


def z(i, j):
    return (i + j) / 2


def costOfMatching(i, j):
    return 0.5 * (((i - j) / 2) - i) * (1 / 16) * (((i - j) / 2) - i)

# Estimated Occlusion:
def Occclude(N, M):
    Occlusion = 3.8
    CostMatrix = [N][M];
    for i in range(1, N):
        CostMatrix[i][0] = i * Occlusion
    for i in range(1, M):
        CostMatrix[0][i] = i * Occlusion
    for i in range(1, N):
        for j in range(1, M):
            CostMatrix[i][j] = min(CostMatrix[i - 1][j - i] + costOfMatching(z(1, i), z(2, j)), C[i][j - 1] + Occlusion,
                                   CostMatrix[i - 1][j] + Occlusion)
    return CostMatrix


"""d is the dimension of the measurement vectors zsis
Ss is the covariance matrix associated with the error (z-zsis)
PDs is the parameter that represents the probability of detecting a measurement occurring from a point xk at sensor s
z1i is a measurement from camera 1, z2i is a measurement from camera 2
Zs is the set of measurements
approximation z = S2i2 * math.pow((S1i1 + S2), (-1)) * z1i1 + S1i1 * math.pow((S1i1 + S2i2), (-1)) * z2i2
probability of occlusion = (1 - PDs)
delta(i) is an indicator variable that is unity if a measurement is not assigned a corresponding point and is zero otherwise
"""
# need to define func S, d, def PDs, M, N
