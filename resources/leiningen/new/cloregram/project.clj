(defproject {{name}} "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :dependencies [[org.clojure/clojure "1.11.2"]
                 [io.github.algoflora/cloregram "0.12.0"]]

  :plugins [[lein-eftest "0.6.0"]]

  :main ^:skip-aot {{name}}.core
  :target-path "target/%s"

  :jvm-opts ["--add-opens=java.base/java.nio=ALL-UNNAMED"
             "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED"]

  :profiles {:dev {:jvm-opts ["-Dconfig.path=config.dev.edn"]}
             :repl {:dependencies [[compojure "1.7.0"]
                                   [ring/ring-json "0.5.1"]]
                    :jvm-opts ["-Dconfig.path=config.dev.edn"]}
             :test {:dependencies [[compojure "1.7.0"]
                                   [ring/ring-json "0.5.1"]]
                    :jvm-opts ["-Dconfig.path=config.test.edn"]}
             :uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
