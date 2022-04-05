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


let isRequestPost = false;
window.addEventListener('scroll',() => {
	// $("#mainPost").height() : DOM의 길이
	// $("#mainPost").offset().top : DOM의 최상단 위치
	//window.pageYOffset : 현제 스크롤 최상단 위치
	//window.innerHeight : 창 길이
	const domPositionY = $("#mainPost").height() + $("#mainPost").offset().top;
	const windowPositionY = window.pageYOffset + window.innerHeight;

	var next_page = parseInt($("#mainPost").attr("current-page")) + 1;
	var userId = $("#user_id").val();


	// if (domPositionY <= windowPositionY && !this.isRequestPost) {
	// 	this.isRequestPost = true;
	// 	// setTimeout(() => this.isRequestPost = false, 1000);
	//
	// 	$.ajax({
	// 		method: "GET",
	// 		url :"/post/page?id=" + userId + "&page=" + next_page
	// 	})
	// 		.done(function (response) {
	// 			window.location.reload();
	// 		});
	// }
});

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

$("input[name='saveComment']").keydown(function (key){
	var userId = $("#user_id").val();
	var postId = parseInt($(this).attr("postId"));
	var content = $("input[name='saveComment']").val();

	if(key.keyCode == 13){
		$.ajax({
			method: "POST",
			url :"/comment",
			data: JSON.stringify({
				"author" :userId,
				"content": content,
				"postId" : postId
			}),
			contentType:"application/json"
		})
			.done(function (response) {
				console.log("comment creation success!");
				window.location.reload();
			});
	}
})

// $("input[name='follow']").click(function () {
// 	console.log("follow click");
// 	var userId = $("#user_id").val();
// 	var otherId = 3;
// 	var isFollow = parseInt($(this).attr("isFollow"));
//
// 	if (isFollow == 1) {
// 		$.ajax({
// 			method: "POST",
// 			url :"/follow",
// 			data: JSON.stringify({
// 				"otherId" :otherId,
// 				"userId": userId
// 			//	임시
// 			}),
// 			contentType:"application/json"
// 		})
// 			.done(function (response) {
// 				window.location.reload();
// 			});
// 		$("input[class='btn-check']").attr("isFollow", 0);
// 	}
// 	else {
// 		$.ajax({
// 			method: "DELETE",
// 			url :"/follow?otherId=" + otherId + "&userId=" + userId,
// 			contentType:"application/json"
// 		})
// 			.done(function (response) {
// 				window.location.reload();
// 			});
// 		$("input[class='btn-check']").attr("isFollow", "1");
// 	}
// });

// Edit 눌렀을 때
$("a[name='updatePostModal']").click(function (){
	var id = parseInt($(this).attr("postId"));
	console.log(id);
	$("a[name='updatePost']").attr("value", id);
	$("div[class='modal-body p-0 mb-3']").attr("updatePostId", id);
});

//Update Modal에서 post 눌렀을 때
$("a[name='updatePost']").click(function (){

	var content = $("#updateText").val();
	var id = parseInt($(this).attr("value"));
	console.log(id);

	$.ajax({
		method:"PUT",
		url:"/post",
		data: JSON.stringify({
			"content" :content,
			"id": id
		}),
		contentType:"application/json"
	}).done(function (response){
		window.location.reload();
	});
});

$("a[name='deletePost']").click(function (){
	var userId = $("#user_id").val();
	var id = parseInt($(this).attr("postId"));
	console.log(id);

	$.ajax({
		method:"PUT",
		url:"/post/delete?id=" + id,
		contentType:"application/json"
	}).done(function (response){
		window.location.reload();
	});
});

$("label[name='deleteComment']").click(function (){
	var commentId = parseInt($(this).attr("commentId"));
	console.log(commentId);

	$.ajax({
		method:"PUT",
		url:"/comment/delete?commentId=" + commentId,
		contentType:"application/json"
	}).done(function (response){
		window.location.reload();
	});
})

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
	var id = $("#userId").val();
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
