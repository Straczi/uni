module Serie2 where

quader :: Num a => a -> a -> a -> (a, a, a)
quader a b c = (a, b , c)

q1 = quader 4 3 2

volume :: Num a => (a, a, a) -> a
volume (a, b, c) = a * b * c

surfaceArea :: Num a => (a, a, a) -> a
surfaceArea (a, b, c) = 2 * (a * b + a * c + b * c)

isCube :: (Eq a, Num a) => (a, a, a) -> Bool
isCube (a, b, c) = a == b && b == c

diagonal :: Floating a => (a, a, a) -> a
diagonal (a, b, c) = sqrt (a ** 2 + b ** 2 + c ** 2)

isBigger :: (Ord a, Num a) => (a, a, a) -> (a, a, a) -> Bool
isBigger a b = volume a > volume b
