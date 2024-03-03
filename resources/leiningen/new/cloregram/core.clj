(ns {{name}}.core
  (:require [cloregram.core :refer [run]]
            #_[cloregram.system.state :refer [system]]
            #_[dialog.logger :as log])
  (:gen-class))

(defn -main
  []
  (run)
  
  ;; Uncomment if you need regular events or delete otherwise
  ;; (log/info "Starting watcher...")
  #_(loop []
    (if (.isRunning (:bot/server @system))
      (do
        (try
          (events/revise)
          (catch Exception e
            (log/warn e)))
        (Thread/sleep 30000)
        (recur))
      (log/info "Watcher stopped"))))
