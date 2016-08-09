/**
 * Global
 */
//java의 생성자
function Global(arg) {
	this.context = arg;
}

//java의 함수
Global.prototype.setContext = function(context) {
	this.context = context;
}
Global.prototype.getContext = function() {
	return this.context;
}