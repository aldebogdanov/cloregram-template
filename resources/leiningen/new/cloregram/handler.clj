(ns {{name}}.handler
  (:require [cloregram.api :as api]))

(defn common
  [{:keys [user message]}]
  (api/send-message user
                    (format "Welcome to {{name}} project, %s!" (:user/username user)) []))
