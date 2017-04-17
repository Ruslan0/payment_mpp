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
      
      
      
