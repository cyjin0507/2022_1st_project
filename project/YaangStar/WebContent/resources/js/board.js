
// index.jsp 게시판 이미지 등록시 사용
$("#imgFile").on('change',()=>{
      let selectFile = document.querySelector("#imgFile").files[0];

      const file = URL.createObjectURL(selectFile);

      $('#board-img').css('background-image', 'url('+ file +')')
      

})

//userController.jsp 게시판 이미지 등록시 사용
$("#img_control").on('change',()=>{
      let selectFile = document.querySelector("#img_control").files[0];

      const file = URL.createObjectURL(selectFile);

      document.querySelector("#img-control-img").src = file;

})

//header.jsp 유저 팝업
     $('#user-pop').on('mouseover', ()=> {
            $('#user-info-pop').css('display', 'block')
        })
        $('#user-pop').on('mouseleave', ()=> {
            $('#user-info-pop').css('display', 'none')
        })