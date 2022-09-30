function searchParent() {
    let child = document.getElementsByTagName('p')[0];
    console.log(child);

    // parentNode: 탐색된 요소(element)의 부모 요소를 탐색한다.
    let parentDiv = child.parentNode;
    console.log(parentDiv);
    parentDiv.style.backgroundColor = 'cornflowerblue';

    console.log(parentDiv.nodeName);
}

function searchChild() {
    let parent = document.getElementsByTagName('div')[0];
    console.log(parent);

    // children은 탐색된 요소의 자식 요소(태그)를 탐색한다. 
    // let childs = parent.children;
    // console.log(childs);

    // console.log(childs[0]);
    // console.log(childs[1]);
    // console.log(childs[2]);

    // childs[0].style.backgroundColor = 'skyblue'
    // childs[1].style.backgroundColor = 'lemonchiffon'
    // childs[2].style.backgroundColor = 'peachpuff'

    // childNodes는 탐색된 요소의 자식 요소(태그 및 텍스트)를 탐색한다.
    childs = parent.childNodes;
    console.log(childs);
    
    console.log(childs[1]);
    console.log(childs[3]);
    console.log(childs[5]);

    childs[1].style.backgroundColor = 'skyblue'
    childs[3].style.backgroundColor = 'lemonchiffon'
    childs[5].style.backgroundColor = 'peachpuff'
}

function testSearch() {
    let child1 = document.getElementsByTagName('p')[3];
    let parentDiv1 = child1.parentNode;
    parentDiv1.style.backgroundColor = 'lightsalmon';

    let parent1 = document.getElementsByTagName('div')[3];
    let childp1 = parent1.childNodes[3];
    childp1.style.fontSize = '20px';
}