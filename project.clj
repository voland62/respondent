(defproject respondent "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
  		 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
		 [org.clojure/clojurescript "0.0-3308"]]

  :repl-options {
                 :prompt (fn [ns] (str "Andrew in " ns "> "))
                 :welcome (println "Hello Andrew!")
                 :init-ns respondent.core
                 :init (println "here you are in" *ns*)}

  :plugins [[com.keminglabs/cljx "0.6.0"]
  	    [lein-cljsbuild "1.0.6"]]

  :cljx {:builds [{:source-paths ["src/cljx"]
  		   :output-path "target/classes"
		   :rules :clj}
		   
		  {:source-paths ["src/cljx"]
		   :output-path "target/classes"
		   :rules :cljs}]}

  

  :prep-tasks [["cljx" "once"] "javac" "compile"]

  :cljsbuild {:builds [{:source-paths ["target/classes"]
  	     	        :compiler {:output-to "target/main.js"}}]}
)
