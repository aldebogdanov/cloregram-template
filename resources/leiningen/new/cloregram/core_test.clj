(ns {{name}}.core-test
  (:require [clojure.test :refer :all]
            [cloregram.validation.fixtures :as fix]
            [cloregram.validation.users :as u]
            [cloregram.validation.client :as c]
            [cloregram.validation.inspector :as i]))

(use-fixtures :once fix/use-test-environment fix/load-initial-data)

(deftest core-test
  (u/add :test-user)

  (c/send-text :test-user "/start")

  (-> (u/main-message :test-user)
      (i/check-text "Welcome to {{name}} project, test-user!")))
