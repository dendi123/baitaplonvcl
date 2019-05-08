# Hướng dẫn cài đặt và sử dụng Grabber
Grabber là 1 web application scanner. Là 1 công củ để kiểm tra các lỗ hổng về bảo mật cho trang web của bạn
Bao gồm các tính năng như: SQL Injection, XSS Attacks, Cross-Site Scripting, Simple AJAX check

## Cài đặt
Trước hết ta cần phải cài đặt Grabber
```
sudo apt install grabber
```
## Các bước thực hiện
### Bước 1: Khởi động Grabber

Để xem các tham số mà Grabber hỗ trợ thì ta gõ lệnh sau
```
sqlmap --help
```
### Bước 2: Bắt đầu việc kiểm thử bảo mật trang web
ví dụ: https://www.uselitewine.com<br>
```
grabber --spider 1 --sql --xss --url ttps://www.uselitewine.com
```
Giải thích:<br>
--url: đường dẫn URL đến trang web cần kiểm tra<br>
--sql: SQL Injection<br>
--xss: XSS Attacks<br>

Đây là kết quả nhận được
![](grabber1.png)<br>

## Kết quả khi áp dụng Grabber để kiểm thử với hoclieu.vn
Ta cần nhập câu lệnh sau
```
grabber --spider 1 --sql --xss --url ttps://www.hoclieu.vn
```

Không thể tìm thấy lỗ hổng nào trên trang hoclieu.vn
![](grabber2.png)<br>
