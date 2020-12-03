(ns kata.exercise7
  (:use [clojure.test]
        [kata.data]))

(testing "Average Age"

  ; Calculate the average of customer ages by using your own (avg ...)
  ;; Don't forget about (apply ...)\

  (defn my-age-avg [xs]
    ( / (reduce + (seq (map :age xs))) (count (map :age xs)) )
    )
  (let [customers (:customers mall)
        avg-age   (apply my-age-avg [customers]) ]

    (is (= avg-age (rationalize 28.7)))))


(testing "How Much for Everything?!"

  ; Calculate the sum of the prices for all the items in all shops by using (flatten ...)
  ;; Don't forget about (apply ...)
  ;;total (reduce + (map :price (mapcat :items shops)))
  ;;total (reduce + (map :price (flatten  (map :items shops))))
  (let [shops (:shops mall)
        total (apply + (map :price (flatten  (map :items shops))))]

    (is (= total 60930))))
