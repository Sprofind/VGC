# VGC.001
##  Overview
VGC là ứng dụng đặt vé xem phim, được phát triển dựa trên những nhu cầu của người dùng về sự tiện lợi khi sử dụng dịch vụ.
#
##Platform
Google Cloud Platform
##More details
  - Người dùng chọn phim từ danh sách.
  - Chọn lịch chiếu theo ngày và rạp chiếu.
  - Chọn vị trí ghế.
  - Xác nhận thanh toán và mua vé.
  
###Database design
<img src="https://i.imgur.com/mFCW5u8.png"/>

###Issues
 - Bản demo chỉ chạy được trên localhost.
 - Chưa kết nối Cloud SQL proxy -> các api chưa trả về giá trị cần thiết.

###VGC demo Swagger-ui
    https://vgv-backend.appspot.com/swagger-ui.html