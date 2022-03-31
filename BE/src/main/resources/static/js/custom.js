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
// 		url : "/main?id=" + id,
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

$("a[name='updatePost']").click(function (){
	console.log("update click");

// 	var content = $("#updateText").val();
// 	var id = parseInt($(this).attr("id"));
// 	var postId = document.getElementsByName("postId")[id].value;
//
//
// //수정 필요 updateModal 내부에  th:attrappend="id=${postStat.index}"가 필요한가?
// 	$.ajax({
// 		method: "PUT",
// 		url :"/post",
// 		data: JSON.stringify({
// 			"content" :content,
// 			"id" : postId
// 		}),
// 		contentType:"application/json"
// 	})
// 		.done(function (response) {
// 			console.log(id);
// 			window.location.reload();
// 		});
});

$("a[name='deletePost']").click(function (){

	var userId = $("#user_id").val();
	var id = parseInt($(this).attr("id"));

	var deletePostCnt = parseInt($("div[id='feed']").attr("deletePostCnt"));
	console.log("delete deletePostCnt : ", deletePostCnt);
	var postId = document.getElementsByName("postId")[id].value;

	console.log("delete click : ", postId);

	$.ajax({
		method:"PUT",
		url:"/post/delete?id=" + postId,
		contentType:"application/json"
	}).done(function (response){
		window.location.reload();
	});

	var deletePostCnt = parseInt($("div[id='feed']").attr("deletePostCnt"));
	var cnt = deletePostCnt + 1;
	$("div[id='feed']").attr("deletePostCnt", cnt);
	//새로고침 후 값 증가시키는 방법
});

$("a[name='moveProfile']").click(function (){
	console.log("move profile");
	var id = parseInt($(this).attr("id"));
	var author = document.getElementsByName("postAuthor")[id].value;
	console.log(author);

	window.location.href = "/profile?id=" + author;
});

$("a[name='moveMyProfile']").click(function (){
	var id = $("#user_id").val();

	window.location.href = "/profile?id=" + id;
});

$("a[name='moveIndex']").click(function (){
	console.log("cliked")
	var id = $("#user_id").val();
	console.log(id);
	window.location.href = "/main?id=" + id;
});

$("a[name='liked']").click(function (){

	var id = parseInt($(this).attr("id"));
	var postId = document.getElementsByName("postId")[id].value;

	console.log(id);
	console.log(postId);

	$.ajax({
		method :"PUT",
		url : "/post/like?id=" + postId,
		contentType:"application/json"
	})
		.done(function (response){
			window.location.reload();
		})
});
