<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Insert title here</title>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <div align="center">
            <h1>Dong thue</h1>
            <form action="<%=request.getContextPath()%>/dongthue" method="post">
                <table style="with: 100%">
                    <tr>
                        <td>Ngày: </td>
                        <td><input type="text" name="date" disabled/></td>
                    </tr>
                    <tr>
                        <td>MST: </td>
                        <td><input type="text" name="masothue" disabled /></td>
                    </tr>
                    <tr>
                        <td>Họ tên: </td>
                        <td><input type="text" name="nguoinopthue" disabled /></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ: </td>
                        <td><input type="text" name="address" disabled /></td>
                    </tr>
                </table>
                <h3>Thông tin ngân hàng</h3>
                <br/>
                <table style="with: 100%">
                    <tr>
                        <td>Tên ngân hàng: </td>
                        <td><input type="text" name="date" /></td>
                    </tr>
                    <tr>
                        <td>STK: </td>
                        <td><input type="text" name="masothue"  /></td>
                    </tr>
                </table>
                <h3>Thông tin cơ quan quản lý thu</h3>
                <br/>
                <table style="with: 100%">
                    <tr>
                        <td>Tỉnh/TP: </td>
                        <td>
                            <div class="input-group w-50 pd-10">
                                <select class="input-text" name="calc_shipping_provinces" required="">
                                    <option value="">Tỉnh / Thành phố</option>
                                    <option value="1">An Giang</option>
                                    <option value="2">Bà Rịa - Vũng Tàu</option>
                                    <option value="3">Bạc Liêu</option>
                                    <option value="4">Bắc Kạn</option>
                                    <option value="5">Bắc Giang</option>
                                    <option value="6">Bắc Ninh</option>
                                    <option value="7">Bến Tre</option>
                                    <option value="8">Bình Dương</option>
                                    <option value="9">Bình Định</option>
                                    <option value="10">Bình Phước</option>
                                    <option value="11">Bình Thuận</option>
                                    <option value="12">Cà Mau</option>
                                    <option value="13">Cao Bằng</option>
                                    <option value="14">Cần Thơ</option>
                                    <option value="15">Đà Nẵng</option>
                                    <option value="16">Đắk Lắk</option>
                                    <option value="17">Đắk Nông</option>
                                    <option value="18">Đồng Nai</option>
                                    <option value="19">Đồng Tháp</option>
                                    <option value="20">Điện Biên</option>
                                    <option value="21">Gia Lai</option>
                                    <option value="22">Hà Giang</option>
                                    <option value="23">Hà Nam</option>
                                    <option value="24">Hà Nội</option>
                                    <option value="25">Hà Tĩnh</option>
                                    <option value="26">Hải Dương</option>
                                    <option value="27">Hải Phòng</option>
                                    <option value="28">Hòa Bình</option>
                                    <option value="29">Hậu Giang</option>
                                    <option value="30">Hưng Yên</option>
                                    <option value="31">Thành phố Hồ Chí Minh</option>
                                    <option value="32">Khánh Hòa</option>
                                    <option value="33">Kiên Giang</option>
                                    <option value="34">Kon Tum</option>
                                    <option value="35">Lai Châu</option>
                                    <option value="36">Lào Cai</option>
                                    <option value="37">Lạng Sơn</option>
                                    <option value="38">Lâm Đồng</option>
                                    <option value="39">Long An</option>
                                    <option value="40">Nam Định</option>
                                    <option value="41">Nghệ An</option>
                                    <option value="42">Ninh Bình</option>
                                    <option value="43">Ninh Thuận</option>
                                    <option value="44">Phú Thọ</option>
                                    <option value="45">Phú Yên</option>
                                    <option value="46">Quảng Bình</option>
                                    <option value="47">Quảng Nam</option>
                                    <option value="48">Quảng Ngãi</option>
                                    <option value="49">Quảng Ninh</option>
                                    <option value="50">Quảng Trị</option>
                                    <option value="51">Sóc Trăng</option>
                                    <option value="52">Sơn La</option>
                                    <option value="53">Tây Ninh</option>
                                    <option value="54">Thái Bình</option>
                                    <option value="55">Thái Nguyên</option>
                                    <option value="56">Thanh Hóa</option>
                                    <option value="57">Thừa Thiên - Huế</option>
                                    <option value="58">Tiền Giang</option>
                                    <option value="59">Trà Vinh</option>
                                    <option value="60">Tuyên Quang</option>
                                    <option value="61">Vĩnh Long</option>
                                    <option value="62">Vĩnh Phúc</option>
                                    <option value="63">Yên Bái</option>
                                </select>
                                <input class="billing_address_1" name="" type="hidden" value="">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Cơ quan quản lý thu: </td>
                        <td>
                            <div class="input-group w-50 pd-10">
                                <select class="input-text" name="calc_shipping_district" required="">
                                    <option value="">Quận / Huyện</option>
                                </select>
                                <input class="billing_address_2" name="" type="hidden" value="">
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <script async="async" defer="defer" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js"></script>
        <script>//<![CDATA[
            window.addEventListener('load',function(){
              if(address_2=localStorage.getItem('address_2_saved')){
                $('select[name="calc_shipping_district"] option').each(function(){
                  if($(this).text()==address_2){$(this).attr('selected','')}
                })
                $('input.billing_address_2').attr('value',address_2)
              }
              if (district = localStorage.getItem('district')) {
                $('select[name="calc_shipping_district"]').html(district)
                $('select[name="calc_shipping_district"]').on('change', function() {
                  var target = $(this).children('option:selected')
                  target.attr('selected', '')
                  $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
                  address_2 = target.text()
                  $('input.billing_address_2').attr('value', address_2)
                  district = $('select[name="calc_shipping_district"]').html()
                  localStorage.setItem('district', district)
                  localStorage.setItem('address_2_saved', address_2)
                })
              }
              $('select[name="calc_shipping_provinces"]').each(function() {
                var $this = $(this),
                  stc = ''
                c.forEach(function(i, e) {
                  e += +1
                  stc += '<option value=' + e + '>' + i + '</option>'
                  $this.html('<option value="">Tỉnh / Thành phố</option>' + stc)
                  if (address_1 = localStorage.getItem('address_1_saved')) {
                    $('select[name="calc_shipping_provinces"] option').each(function() {
                      if ($(this).text() == address_1) {
                        $(this).attr('selected', '')
                      }
                    })
                    $('input.billing_address_1').attr('value', address_1)
                  }
                  $this.on('change', function(i) {
                    i = $this.children('option:selected').index() - 1
                    var str = '',
                      r = $this.val()
                    if (r != '') {
                      arr[i].forEach(function(el) {
                        str += '<option value="' + el + '">' + el + '</option>'
                        $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>' + str)
                      })
                      var address_1 = $this.children('option:selected').text()
                      var district = $('select[name="calc_shipping_district"]').html()
                      localStorage.setItem('address_1_saved', address_1)
                      localStorage.setItem('district', district)
                      $('select[name="calc_shipping_district"]').on('change', function() {
                        var target = $(this).children('option:selected')
                        target.attr('selected', '')
                        $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
                        var address_2 = target.text()
                        $('input.billing_address_2').attr('value', address_2)
                        district = $('select[name="calc_shipping_district"]').html()
                        localStorage.setItem('district', district)
                        localStorage.setItem('address_2_saved', address_2)
                      })
                    } else {
                      $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>')
                      district = $('select[name="calc_shipping_district"]').html()
                      localStorage.setItem('district', district)
                      localStorage.removeItem('address_1_saved', address_1)
                    }
                  })
                })
              })
            })
            //]]>
        </script>
    </body>
</html>