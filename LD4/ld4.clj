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
;rows 0 1 2...
(defn calculate-index [length key]
	(def current-row 0)
	(def go-row-down false) ;for direction
	(vec
		(for [column (range 0 length)]
			(do
				(if (or(= current-row 0) (= current-row (- key 1))) ;when to change direction
					(def go-row-down (not go-row-down))
				)
				(def matrix-index (+ column (* current-row length))) 
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


(defn zipmap-encrypt-chars [message key]
	(zipmap 
		(calculate-index(count message) key)( vec message)
	)
)

(defn do-encryption [message key]
	(str/join
		(for [[position char]
			(sort-by first (zipmap-encrypt-chars message key))
			]
			char
		)	
	)
)


(defn encrypt [message key]
	(if (char-valid message key)
		(do-encryption (replace-space message) key)
		(str "Error: Invalid message or key!")
	)
)

(defn zipmap-decrypt-chars [message key]
	(zipmap
		(sort (calculate-index (count message) key)) ;chars are already sorted, so calculatedindex must be sorted
		(vec message)
	)
)

(defn decrypt-index [old-index length]
	(mod old-index length)
)


(defn do-decryption [message key]
	(str/join
		(for [[position char]
			(sort-by first 
				
					(for [[pos char] (zipmap-decrypt-chars message key)]
						[(decrypt-index pos (count message)) char ]
					)
				
			)
			]
			char
		)	
	)
)


(defn decrypt [message key]
	(if (char-valid message key)
		(do-decryption (replace-space message) key)
		(str "Error: Invalid message or key!")
	)
)