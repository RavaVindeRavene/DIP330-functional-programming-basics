(ns kata.exercise8
  (:use [clojure.test]
        [kata.data]))

(testing "Nowhere to be Found"

  ; Create a set of item names that are in {@link customer->wants-to-buy} but not on sale in any shop.
  (let [
        customers_want (set (map :name (mapcat :wants-to-buy (:customers mall))))
        shops_have (set (map :name (mapcat :items (:shops mall))))
        not-for-sale (set (remove shops_have customers_want))
        ]

    (is (= not-for-sale #{"bag", "pants", "coat"}))))

(testing "I see it, I like it, I want it, I got it "

  ; Create a customers' name list including who are having enough money to buy all items they want which is on sale.
  ; Items that are not for sale can be counted as 0 money cost.
  ; If there are multiple items with the same names, but different prices, customer will choose the cheapest one.
  (let [
        shops_have (mapcat :items (:shops mall))
        richies []

        ]

    (is (= richies ["Joe", "Patrick", "Chris", "Kathy", "Alice", "Andrew", "Amy"]))))
