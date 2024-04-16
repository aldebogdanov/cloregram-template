(ns {{name}}.core
  (:require [cloregram.core :refer [run]]
            #_[cloregram.system.state :refer [system]]
            #_[com.brunobonacci.mulog :as μ])
  (:gen-class))

(defn -main
  []
  (run)
  
  ;; Uncomment if you need regular events or delete otherwise
  (comment 
  
    (μ/log ::watcher-starting)
    (loop []
      (if (.isRunning (:bot/server @system))
        (do
          (try
            (events/revise)
            (catch Exception e
              (log/warn e)))
          (Thread/sleep 30000)
          (recur))
        (μ/log ::watcher-stopped)))))
