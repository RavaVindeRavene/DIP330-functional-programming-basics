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
;length=count message
;height=key
(defn calculate-index [length height]
	(def current-row 0)
	(def go-row-down false)
	(vec
		(for [column (range 0 length)]
			(do
				(if (or(= current-row 0) (= current-row (- height 1)))
					(def go-row-down (not go-row-down))
				)
				(def matrix-index (+ column (* current-row))
				(def current-row
					(if (true? go-row-down)
						(inc current-row)
						(dec current-row)
					)
				)
				matrix-index
			)
		)
	)

)
;returns a vector/list of indexes and the chars of string
; from [0 1 2 3 4 5] to something like [0 11 22 13 4 15]
; this is key and chars of string is value? -> zipmap or for cycle to arrange that

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