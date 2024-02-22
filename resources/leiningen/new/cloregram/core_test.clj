(ns {{name}}.core-test
  (:require [clojure.test :refer :all]
            [cloregram.test.fixtures :as fix]
            [cloregram.test.infrastructure.users :as u]
            [cloregram.test.infrastructure.client :as c]
            [cloregram.test.infrastructure.inspector :as i]))

(use-fixtures :once fix/use-test-environment fix/setup-schema)

(deftest core-test
  (u/add :test-user)

  (c/send-text :test-user "/start")

  (-> (u/wait-main-message :test-user)
      (i/check-text "Welcome to {{name}} project, test-user!")))
