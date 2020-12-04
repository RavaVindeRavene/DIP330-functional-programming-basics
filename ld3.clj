;; 1. Find the last element of a list.
(defn my-last [xs]
 (if (empty? (rest xs))
    (first xs)
    (my-last(rest xs))
 )
)

(assert (= :d
           (my-last '(:a :b :c :d))))

;; 2. Find the N-th element of a list.
(defn get-nth [xs n]
   (if (= n 0)
    (first xs)
    (recur (rest xs) (dec n))
  )
)

(assert (= :c
           (get-nth '(:a :b :c :d) 2)))


;; 3. Find the length of a list
(defn my-length [xs]
  (if (empty? xs)
    0
    (inc (my-length(next xs)))
    )
  )  

(assert (= 4
           (my-length '(:a :b :c :d))))

;; 4. Reverse a list.
(defn my-reverse [xs]
  (if (not-empty xs)
   (cons (last xs)(my-reverse(butlast xs)))
  )
)

(assert (= '(:d :c :b :a)
           (my-reverse '(:a :b :c :d))))

;; 5. Find out whether a list is a palindrome.

(defn is-palindrome? [xs]
  (if (not-empty xs) 
      (if (= (first xs) (last xs)) 
          (is-palindrome? (butlast(rest xs)))
      )
    true
  )
)

(assert (= true
           (is-palindrome? '(:a :b :c :b :a))))

;; 6. Duplicate the elements of a list.
(defn duplicate [xs]
  ( if (not-empty xs)
      (cons (first xs)
          (cons (first xs) 
                (duplicate (rest xs))
          )
      )
  )
)

(assert (= '(:a :a :b :b :c :c)
           (duplicate '(:a :b :c))))

;; 7. Eliminate consecutive duplicates of a list.
;;it works only if the element repeats next to it like in the given example
(defn compress [xs]
  (if (empty? xs)
    '()
    (if (not= (first xs)(first(next xs)))
          (cons (first xs) (compress(rest xs)))
          (compress (rest xs))

    )
  )
)
(assert (= '(:a :b :c)
           (compress '(:a :a :b :b :c :c))))

;; 8. Remove the N-th element of a list
(defn remove-at [xs n]
    (if (= n 0)
    (rest xs)
    (cons (first xs)(remove-at (rest xs) (dec n)))
  )
)

(assert (= '(:a :b :d :e)
           (remove-at '(:a :b :c :d :e) 2)))

;; 9. Insert a new element at the N-th position of a list.
(defn insert-at [x xs n]
   (when (seq xs)
      (if (= n 0)
        (cons x xs )
        (cons (first xs)(insert-at x (rest xs) (dec n)))
      )
   )
)


(assert (= '(:a :b :x :c :d)
           (insert-at :x '(:a :b :c :d) 2)))

;; 10. Create a list containing all integers within a given range.
(defn my-range [a b]
   (if (not= (- b a) -1)
    ( cons a (my-range (inc a) b))
   )
)
(assert (= '(3 4 5 6 7)
           (my-range 3 7)))

;; 11. Concatenate two lists
(defn my-concat [xs ys]
  ( if (empty? xs)
    ys
    (cons (first xs) (my-concat (next xs) ys)) 
  )
)
(assert (= '(:a :b :c :d :e :f)
           (my-concat '(:a :b :c) '(:d :e :f))))

;; 12. Split a list into two parts; the length of the first part is given.
(defn my-drop [xs n]
    (if (= (- n 1) 0)
      (rest xs)
    (recur (rest xs) (dec n)) 
    )
  )


(assert (= '(:d :e)
           (my-drop '(:a :b :c :d :e) 3)))

;; 13. Split a list into two parts; the length of the first part is given.
(defn my-take [xs n]
      (if (not-empty xs)
        (if (= n 0)
        '()
        (cons (first xs) (my-take (rest xs) (dec n))) )
      )
)

(assert (= '(:a :b :c)
           (my-take '(:a :b :c :d :e) 3)))

;; 14. Implement the filtering function
(defn my-filter [p xs]
  (when (seq xs)
    (if (p (first xs))
        (cons (first xs) (my-filter p (next xs)))
    (my-filter p (next xs))
    )
  )
)

(assert (= '(1 3 5)
           (my-filter odd? '(1 2 3 4 5))))

;; 15. Implement the mapping function
(defn my-map [m xs]
  (if (seq xs)
    (cons (m (first xs)) (my-map m (next xs))
    )
  )
)

(assert (= '(2 3 4 5 6)
           (my-map inc '(1 2 3 4 5))))

;; 16. Implement the reducing function
(defn my-reduce [f acc xs]
  (if (seq xs)
	(f (first xs) (my-reduce f acc (next xs)))acc)
)

(assert (= 15
           (my-reduce + 0 '(1 2 3 4 5))))

;; 17. Implement the flattening function
(defn my-flatten [xs] 
  (loop [list1 xs, list2 `()]
    (cond (sequential? (first list1)) 
      (recur (my-concat(first list1) (rest list1)) list2)
        (empty? list1) 
            (my-reverse list2)
      :else (recur (rest list1) (cons (first list1) list2))
    )
  )
)

(assert (= '(:a :b :c :d :e)
           (my-flatten '(:a (:b (:c :d) :e)))))