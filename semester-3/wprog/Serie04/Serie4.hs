module Serie4 where

import Data.List

testDoubles :: String -> Bool
testDoubles a = testDoubles2 (words a)

testDoubles2 :: [String] -> Bool
testDoubles2 [] = False
testDoubles2 [x] = False
testDoubles2 [x, y] = x == y
testDoubles2 a =
  (head a == a !! 1) || testDoubles2 (tail a)

listDoubles :: String -> [String]
listDoubles a = listDoubles2 (words a)

listDoubles2 :: [String] -> [String]
listDoubles2 [] = []
listDoubles2 [a] = []
listDoubles2 (x:xs) = if x == head xs then x:listDoubles2 xs else listDoubles2 xs