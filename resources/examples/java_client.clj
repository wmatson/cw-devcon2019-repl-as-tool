(ns scratchpad.services.fx-client
  (:require [com.climate.claypoole :as cp])
  (:import [com.ca.fx.client FxClient]
           [com.ca.util.date GlobalDate GlobalDates]))

(def fx-client (FxClient.))

(defn get-rate [account-id from-currency to-currency date-string]
  (try
    (let [spot-rate-repo (.. fx-client
                             getSpotRateRepositoryResource
                             fetchSpotRateRepository)]
      (.lookupBalanceSheetRate spot-rate-repo account-id
                               from-currency to-currency
                               (GlobalDates/create date-string "yyyy-MM-dd")))
    (catch Exception e
      (ex-info "It's broken" {:account-id account-id} e))))

(comment
  ;;All accounts from PRC-3640
  (let [account-ids [3 1 4 15 9 2 6 53 89 79 ,,,]]
    (cp/upmap 20 #(get-rate % 4 1 "2018-09-04") account-ids))

  (get-rate 12345 10 1 "2018-08-30"))
