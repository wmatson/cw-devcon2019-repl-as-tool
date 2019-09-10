(ns clj2018-scratchpad.one-offs.rawsp-request-size-profiling
  (:require [clj2018-scratchpad.rawsp.core :as rawsp]
            [clj2018-scratchpad.services.portfolio :as portfolio]
            [com.climate.claypoole :as cp]
            [taoensso.tufte :as tufte]))

(defn- large-request [{:keys [sec-ids source-ids date]}]
  (tufte/p :rawsp/large-request
           (doall (rawsp/full-lookup sec-ids source-ids date date))))

(defn- partition-sec-ids [{:keys [sec-ids source-ids date]}]
  (tufte/p :rawsp/sec-partitions
           (doall (->> (partition-all 200 sec-ids)
                       (cp/pmap 50 #(rawsp/full-lookup % source-ids date date))
                       (apply merge)))))

(defn- partition-src-ids [{:keys [sec-ids source-ids date]}]
  (tufte/p :rawsp/source-partitions
           (doall (->> (partition-all 1 source-ids)
                       (cp/pmap 20 #(rawsp/full-lookup sec-ids % date date))
                       (apply merge)))))

(tufte/add-basic-println-handler! {})
(tufte/profile {:dynamic? true}
  (dotimes [_ 20]
    (let [date "2019-05-15"
          sec-ids (portfolio/get-securities {:account-ids [61191] :date date})
          params {:date date :sec-ids sec-ids :source-ids [6 16 8 8 14 15 29 18]}]
      (= (large-request params)
         (partition-sec-ids params)
         (partition-src-ids params)))))
