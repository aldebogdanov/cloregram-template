(ns leiningen.new.cloregram
  (:require [leiningen.new.templates :as tmpl]
            [leiningen.core.main :as main]))

(def render (tmpl/renderer "cloregram"))

(defn cloregram
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (tmpl/name-to-path name)}]
    (main/info "Generating fresh 'lein new' weedbreed/cloregram project.")
    (tmpl/->files data
                  ["resources/config.edn" (render "config.edn" data)]
                  ["resources/dialog.edn" (render "dialog.edn" data)]
                  ["resources/schema/empty.edn" (render "empty.edn" data)]
                  ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
                  ["src/{{sanitized}}/handler.clj" (render "handler.clj" data)]
                  ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)]
                  [".gitignore" (render "gitignore" data)]
                  ["project.clj" (render "project.clj" data)])))
