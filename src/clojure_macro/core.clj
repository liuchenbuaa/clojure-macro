(ns clojure-macro.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defmacro myor
  ([x] x)
  ([x & next]
   `(let [or# ~x]
      (if or# or# (myor ~@next)))))

(defmacro print124
  [t]
  t
  )

(defmacro infix
  [params]
  (list (second params) (first params) (last params)))

(defmacro whenx
  [cond & body]
  (list 'if cond (cons 'do body)))

(defmacro myprint [x]
  (list (quote let) [(quote var) x]
        (list 'println 'var)
        'var))

(defmacro whenxx
  [cond & body]
  (list 'if cond `(~cons do body)))

(defmacro code-critic
  [bad good]
  (list 'do
        (list 'println
              "Great squid of Madrid, this is bad code:"
              (list 'quote bad))
        (list 'println
              "Sweet gorilla of Manila, this is good code:"
              (list 'quote good))))

(defmacro critic
  [bad good]
  (list 'do
        (list 'println
              "this is the bad code"
              (list 'quote bad))
        (list 'println
              "this is the good code"
              (list 'quote good)
         )
   ))

(defmacro critic2
  [bad good]
  `(do
     (println "this is the bad code" (quote ~bad))
     (println "this is the good code" (quote ~good))))
