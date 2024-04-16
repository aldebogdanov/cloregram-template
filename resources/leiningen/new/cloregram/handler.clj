(ns {{name}}.handler
  (:require [cloregram.api :as api]
            [cloregram.utils :as utl]))

(defn common
  [{:keys [user message]}]
  (api/send-message user
                    (format "Welcome to {{name}} project, %s!" (utl/username user)) []))

;; Uncomment if you need payment processing or remove otherwise
(comment

  (defn payment
    [{:keys [user payment]}]
    (api/send-message user
                      (format "Successful payment of %d %s with payload %s from %s"
                              (/ (:total_amount payment) 100)
                              (:currency payment)
                              (:invoice_payload payment)
                              (utl/username user))
                      [] :temp)))
