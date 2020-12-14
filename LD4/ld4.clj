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

;(defn calculate-index [length height])

;(defn do-encryption [message key])
;(defn do-decryption [message key])


;(defn encrypt [message key]
	;(if (char-valid message key)
		;(do-encryption (replace-space message) key)
		; (str "Error: Invalid message or key!")
	;)
;)
;(defn decrypt [message key]
	;(if (char-valid message key)
		;(do-decryption (replace-space message) key)
		;(str "Error: Invalid message or key!")
	;)
;)