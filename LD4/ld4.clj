(use 'clojure.core)
(require '[clojure.string :as str])

(defn replace-space [message]
  (str/replace message #" " "_")
  )

(defn char-valid [message key]
  (if (re-matches #"^[A-Za-z\s_]+$" message)
    (> key 1)
    false)
  )
