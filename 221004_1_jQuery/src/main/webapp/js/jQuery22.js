$(() => {

    $('#emp_search').click(() => {
        // 조회할 사원 번호를 얻어온다.
        let empid = $('input:text[name=empid]').val();
        // 3자리 숫자만 입력받는다.
        // isNaN(): 인수로 지정된 내용이 숫자가 아니면 true, 숫자면 false를 리턴한다.
        if (!isNaN(empid) && empid.length == 3) {

// ============================jQuery Ajax============================

            $.ajax({
                // 호출할 페이지 주소(요청) 또는 읽어올 xml 파일명을 적는다.
                url: 'emplist.xml', // (필수)
                cache: false, // 사용자 캐시 사용 여부
                method: 'get', // 서버에 데이터를 요청하는 방식 (필수)
                asyn: true, // 비동기 방식 사용 여부(false는 동기 방식, true는 비동기 방식) (필수)
                dataType: 'xml', // 전송받는 데이터 타입(xml, json, html, script)
                data: { // method가 post로 지정된 경우 서버로 전송할 데이터 목록
                    'key' : 'value'
                },
                // success는 Ajax 요청이 성공했을 때 실행할 콜백 함수를 적는다. 
                // Ajax 요청이 성공하면 응답받는 데이터가 콜백 함수의 인수로 넘어온다.
                success: data => { // (필수)
                // alert('요청 성공');
                // console.log(data);
                
                // 입력한 사원 번호에 해당되는 데이터를 출력해야 하기 때문에 검색한 사원 번호의 부모 요소를 선택한다.
                    let empInfo = $(data).find('EMPLOYEE_ID:contains(' + empid + ')').parent();
                    // console.log(empInfo.html())

                    // 검색된 사원 번호에 해당되는 데이터가 있으면 화면에 출력한다.
                    // 검색된 사원 번호의 부모는 <ROW>이므로, 검색된 내용에 'ROW'가 있으면 테이블에 데이터를 출력하고 없으면 에러 메시지를 출력한다.
                    if ($(empInfo).is('ROW')) {
                        // console.log('있음');

                        // table 태그의 자손 input의 개수만큼 반복하며 xml파일에서 읽어온 데이터를 채워 넣는다.
                        $('table input').each(function (index, obj) {
                            // console.log(index, obj);
                            let search = $(empInfo).children().eq(index).text();
                            // obj.value = search; // javascript
                            $('table input').eq(index).val(search); // jQuery
                        });
                    } else {
                        // console.log('없음');
                        alert(empid + '번은 존재하지 않는 사원번호입니다.');
                    }
                    $('input:text[name=empid]').val('');
                    $('input:text[name=empid]').focus();
                },
                // error는 Ajax 요청이 실패했을 때 실행할 콜백 함수를 적는다.
                error: e => { // (필수)
                    // alert('요청 실패');
                    console.log(e.status + ': ' + e.statusText);
                }
            });

// ============================jQuery Ajax============================

        } else {
            alert('정확한 사원 번호를 입력하세요.');
            $('input:text[name=empid]').val('');
            $('input:text[name=empid]').focus();
        }
        
    });

});