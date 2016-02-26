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

(defmacro print
  [t]
  (list 'println t)
  t)
