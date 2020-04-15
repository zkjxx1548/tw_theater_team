import {ajax} from "./ajax.js";

const API_ROOT = "http://localhost:8080";
const $main = document.getElementById("main");

function getLocationKeyword() {
  return window.location.search.split("=")[1];
}

function ajaxFailed(err) {
    console.log(err);
}

function getResultsDataFromKeyword() {
  ajax({
    url: `${API_ROOT}/search?keyword=${getLocationKeyword()}`,
    method: "get",
    onSuccess: renderResults,
    onFail: ajaxFailed
  })
}
  
function renderResults(arr) {
  document.title=`搜索结果 - ${decodeURI(getLocationKeyword())}`;
  if (arr.length > 0) {
    $main.innerHTML = `<h1>搜索: ` + `${decodeURI(getLocationKeyword())}</h1>`
      + `<p>找到${arr.length}个相关结果</p>`;
    for (let i = 0; i < arr.length; i++) {
      $main.innerHTML += `<div class="search-div">`
      + `<a href="./details.html?id=${arr[i].id}">`
      + `<img src=${arr[i].image} alt="poster" /></a>`
      + `<p class="search-info">`
      + `<span class="info-title"><a href="./details.html?id=${arr[i].id}">`
      + `${arr[i].title} (${arr[i].year})</a></span>`
      + `<span>评分: ${arr[i].rating}</span>`
      + `<span>${updateArr(arr[i].genres)} / `
      + `${isCommonName(arr[i].title, arr[i].originalTitle)}</span>`
      + `<span>${updateArr(arr[i].cast)}</span>`
      + `<span class="search-summary">${arr[i].summary}</span>`
      + `</p>`
      + `</div>`
    }
  }else{
    $main.innerHTML = `<h1>搜索: ` + `${decodeURI(getLocationKeyword())}</h1>`
    + `<div id="search-fail"><img src="./static/fail.svg" alt="logo" />`
    + `<p>未找到相关电影!</p>`
    + `</div>`;
  }
}

function updateArr(arr) {
  let res = "";
  for (let i = 0; i < arr.length - 1; i++) {
    res += arr[i] + " / ";
  }
  return res + arr[arr.length - 1];
}

function isCommonName(name1, name2) {
  if (name1 === name2) {
    return name1;
  }
  return name1 + " / " + name2;
}

window.onload = () => {
  getResultsDataFromKeyword();
};