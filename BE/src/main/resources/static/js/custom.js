/*
Template Name: Vogel - Social Network & Community HTML Template 
Author: Askbootstrap
Author URI: https://themeforest.net/user/askbootstrap
Version: 1.0
*/

(function ($) {
	"use strict"; // Start of use strict

	var Popular = {
		init: function () {
			this.Basic.init();
		},

		Basic: {
			init: function () {

				this.ListSlider();

			},

			// list_slider
			ListSlider: function () {
				$('.account-slider').slick({
					dots: false,
					arrows: false,
					infinite: false,
					speed: 300,
					slidesToShow: 4.2,
					slidesToScroll: 4.2,
					responsive: [
					  {
						breakpoint: 1024,
						settings: {
						  slidesToShow: 4.5,
						  slidesToScroll: 4.5,
						}
					  },
					  {
						breakpoint: 680,
						settings: {
						  slidesToShow: 2.5,
						  slidesToScroll: 2.5
						}
					  },
					  {
						breakpoint: 520,
						settings: {
						  slidesToShow: 3.5,
						  slidesToScroll: 3.5
						}
					  },
					  {
						breakpoint: 422,
						settings: {
						  slidesToShow: 2.5,
						  slidesToScroll: 2.5
						}
					  }
					]
				  });
			},

			

		}
	}
	jQuery(document).ready(function () {
		Popular.init();
	});

})(jQuery); // End of use strict

//로그인 클릭시 user_id에 맞게 조회해줌
// $("#로그인 id").click(function (){
// 	console.log("로그인 완료");
// 	var id = $("#user_id").val();
//
// 	$.ajax({
// 		method: "GET",
// 		url : "/post/all?id=" + id,
// 		contentType: "application/json"
// 	})
// 		.done(function (response){
// 			window.location.reload();
// 		})
// })

$("#create_post").click(function (){
	console.log("create click");
	var content = $("#floatingTextarea2").val();
	var author = $("#user_id").val();

	$.ajax({
		method: "POST",
		url :"/post",
		data: JSON.stringify({
			"content" :content,
			"author": author
		}),
		contentType:"application/json"
	})
		.done(function (response) {
			console.log("post creation success!");
			window.location.reload();
		});
});

$("#follow").click(function () {
	console.log("follow click");
});

$("#updatePost").click(function (){
	console.log("update click");
	var content = $("#updateText").val();
	var id = $("#postId").val();

	$.ajax({
		method: "PUT",
		url :"/post",
		data: JSON.stringify({
			"content" :content,
			"id" : id
		}),
		contentType:"application/json"
	})
		.done(function (response) {
			console.log(id);
			window.location.reload();
		});
});

$("#deletePost").click(function (){
	console.log("delete click");
	var id = $("#postId").val();

	$.ajax({
		method:"PUT",
		url:"/post/delete?id=" + id,
		contentType:"application/json"
	})
		.done(function (response){
			window.location.reload();
		})
});

$("#moveProfile").click(function (){
	console.log("move profile");
	var id = $("#postAuthor").val();

	window.location.href = "/profile?id=" + id;
});

$("#moveMyProfile").click(function (){
	var id = $("#user_id").val();

	window.location.href = "/profile?id=" + id;
});

$("#moveIndex").click(function (){
	console.log("cliked")
	var id = $("#user_id").val();
	window.location.href = "/index?id=" + id + "&postId=1";
});

$("button[name='liked']").click(function (){

	var id = $("input[name='postId']").val();
	var cid = $("input[name='postId']").length;
	console.log(cid);
	var grparr = new Array(cid);

	for(var i = 0; i < cid; i++){
		grparr[i] = $("input[name='postId']").eq(i).val();
		console.log(grparr[i]);
	}

	// $.ajax({
	// 	method :"PUT",
	// 	url : "/post/like?id=" + id,
	// 	contentType:"application/json"
	// })
	// 	.done(function (response){
	// 		window.location.reload();
	// 	})
});
