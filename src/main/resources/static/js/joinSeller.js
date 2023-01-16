let isSameCheckUsername = false;
let isSameCheckEmail = false;

$("#btnJoinSeller").click(() => {
    if (isSameCheckUsername == false) {
        alert("아이디 중복체크를 해주세요");
        return;
    }

    if (isSameCheckEmail == false) {
        alert("이메일 중복체크를 해주세요");
        return;
    }

    if (blankCheckUsername() == false) {
        alert("아이디에 공백이 있으면 안됩니다");
        return;
    }

    if (blankCheckPassword() == false) {
        alert("비밀번호에 공백이 있으면 안됩니다");
        return;
    }

    if (blankCheckSellerName() == false) {
        alert("이름에 공백이 있으면 안됩니다");
        return;
    }

    if (blankCheckSellerEmail() == false) {
        alert("이메일에 공백이 있으면 안됩니다");
        return;
    }

    if (koreanCheckUsername()) {
        alert("아이디는 한글 입력할 수 없습니다");
        return;
    }

    if (koreanCheckSellerEmail()) {
        alert("이메일에는 한글 입력할 수 없습니다");
        return;
    }

    joinSeller();
});

function joinSeller() {
    let data = {
        username: $("#username").val(),
        password: $("#password").val(),
        sellerName: $("#sellerName").val(),
        sellerEmail: $("#sellerEmail").val()
    };

    $.ajax("/join/seller", {
        type: "POST",
        dataType: "json",
        data: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
    }).done((res) => {
        if (res.code == 1) {
            alert("판매자 회원가입 성공");
            location.href = "/login";
        } else {
            alert("가입 실패");
            return false;
        }
    });
}

// 중복체크
$("#btnSameCheckUsername").click(() => {
    sameCheckUsername();
});

function sameCheckUsername() {
    let username = $("#username").val();

    $.ajax("/users/samecheck/" + username, {
        type: "GET",
        dataType: "json",
        async: true
    }).done((res) => {
        if (res.code == 1) {
            if (res.data == false) {
                alert("중복이 아닙니다. 사용할 수 있습니다.");
                isSameCheckUsername = true;
            } else {
                alert("중복입니다. 다른 아이디를 사용하세요.");
                isSameCheckUsername = false;
                $("#username").val("");
            }
        }
    });
}

$("#btnSameCheckEmail").click(() => {
    sameCheckEmail();
});

function sameCheckEmail() {
    let sellerEmail = $("#sellerEmail").val();

    $.ajax("/users/samecheck/" + sellerEmail, {
        type: "GET",
        dataType: "json",
        async: true
    }).done((res) => {
        if (res.code == 1) {
            if (res.data == false) {
                alert("중복이 아닙니다. 사용할 수 있습니다.");
                isSameCheckEmail = true;
            } else {
                alert("중복입니다. 다른 이메일을 사용하세요.");
                isSameCheckEmail = false;
                $("#sellerEmail").val("");
            }
        }
    });
}

// 공백체크
function blankCheckUsername() {
    let username = $("#username").val();
    let reg = /\s/g;
    if (reg.test(username)) {
        return false;
    } else {
        return true;
    }
}

function blankCheckPassword() {
    let password = $("#password").val();
    let reg = /\s/g;
    if (reg.test(password)) {
        return false;
    } else {
        return true;
    }
}

function blankCheckSellerName() {
    let sellerName = $("#sellerName").val();
    let reg = /\s/g;
    if (reg.test(sellerName)) {
        return false;
    } else {
        return true;
    }
}

function blankCheckSellerEmail() {
    let sellerEmail = $("#sellerEmail").val();
    let reg = /\s/g;
    if (reg.test(sellerEmail)) {
        return false;
    } else {
        return true;
    }
}

// 한글체크
function koreanCheckUsername() {
    let username = $("#username").val();
    let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
    if (korRule.test(username)) {
        return true;
    } else {
        return false;
    }
}

function koreanCheckSellerEmail() {
    let sellerEmail = $("#sellerEmail").val();
    let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
    if (korRule.test(sellerEmail)) {
        return true;
    } else {
        return false;
    }
}