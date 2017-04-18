https://docs.spreedly.com/basics/purchase/
https://docs.spreedly.com/reference/api/v1/#redact36
https://blog.spreedly.com/2014/12/18/pci-dss-v3-0-for-online-merchants/      

Autorization:
Test
Key: NMZajRzFonIo6tyliG3oU7viSTx
Unrestricted Payment Method Submission 

sinsay
Access Secret:
2zEEkrZ4nvWNpAn4BbJCHpjhgXJhUlqstRXdZl4l4Z4i4lWV0YLbejfvAWClKRdA


curl https://core.spreedly.com/v1/gateways.json \
-u 'VGVzdDpOTVphalJ6Rm9uSW82dHlsaUczb1U3dmlTVHg=' \
-H ‘Content-Type: application/json’ \
-d ‘{
  "gateway": {
    "gateway_type": "test"
  }
}’



$ curl https://core.spreedly.com/v1/gateways.json \
  -u 'NMZajRzFonIo6tyliG3oU7viSTx:2zEEkrZ4nvWNpAn4BbJCHpjhgXJhUlqstRXdZl4l4Z4i4lWV0YLbejfvAWClKRdA' \
  -H 'Content-Type: application/json' \
  -d '{
        "gateway": {
          "gateway_type": "test"
        }
      }'
      
      
  {
  "transaction": {
    "token": "Q4t8wm16yMXZQmrxlf5u0rtO4wF",
    "created_at": "2017-04-18T16:41:28Z",
    "updated_at": "2017-04-18T16:41:28Z",
    "succeeded": true,
    "transaction_type": "AddPaymentMethod",
    "retained": false,
    "state": "succeeded",
    "message_key": "messages.transaction_succeeded",
    "message": "Succeeded!",
    "payment_method": {
      "token": "SB8Jovm2BGbsDt8p11sKVPzFLnO",
      "created_at": "2017-04-18T16:41:28Z",
      "updated_at": "2017-04-18T16:41:28Z",
      "email": "joey@example.com",
      "data": null,
      "storage_state": "cached",
      "test": true,
      "last_four_digits": "4444",
      "first_six_digits": "555555",
      "card_type": "master",
      "first_name": "Joe",
      "last_name": "Jones",
      "month": 3,
      "year": 2032,
      "address1": null,
      "address2": null,
      "city": null,
      "state": null,
      "zip": null,
      "country": null,
      "phone_number": null,
      "company": null,
      "full_name": "Joe Jones",
      "eligible_for_card_updater": true,
      "shipping_address1": null,
      "shipping_address2": null,
      "shipping_city": null,
      "shipping_state": null,
      "shipping_zip": null,
      "shipping_country": null,
      "shipping_phone_number": null,
      "payment_method_type": "credit_card",
      "errors": [],
      "fingerprint": "2edbf2f75ce12b674a74cf41e829a379b08d",
      "verification_value": "XXX",
      "number": "XXXX-XXXX-XXXX-4444"
    }
  }
}
{
  "transaction": {
    "payment_method_token": "SB8Jovm2BGbsDt8p11sKVPzFLnO",
    "amount": 100,
    "currency_code": "USD"
  }
  
  https://core.spreedly.com/v1/C1dooNXSzHVTZ9bBDrw5B0EKqjf/purchase.json
}