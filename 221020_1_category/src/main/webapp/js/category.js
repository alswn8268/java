function formCheck(obj) {
	if (!obj.category.value || obj.category.value.trim().length == 0) {
		alert('카테고리는 반드시 입력해야 합니다.');
		obj.category.value = '';
		obj.category.focus();
		return false;	
	}
	return true;
}