/**
 * Hanbit factory : 즉시 실행함수
 */

	(function() {
		$.fn.extend({
			global : function(arg) {
				return new Global(arg);
			},
			article : function() {
				return new Article();
			},
			admin : function() {
				return new Admin();
			},
			grade : function() {
				return new Grade();
			},
			member : function() {
				return new Member();
			}
		});
	})();