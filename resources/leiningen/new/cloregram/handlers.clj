(ns {{name}}.handlers
  (:require [cloregram.api :as api]
            [cloregram.dynamic :refer :all]  
            [cloregram.utils :as utl]))

(defn main
  [{:keys [message]}]
  (api/send-message *current-user*
                    (format "Welcome to {{name}} project, %s!" (utl/username *current-user*)) []))

;; Uncomment if you need payment processing or remove otherwise
(comment

  (defn payment
    [{:keys [payment]}]
    (api/send-message *current-user*
                      (format "Successful payment of %d %s with payload %s from %s"
                              (/ (:total_amount payment) 100)
                              (:currency payment)
                              (:invoice_payload payment)
                              (utl/username *current-user*))
                      [] :temp)))
