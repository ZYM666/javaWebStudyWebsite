/**
 * Created by Vove on 2017/5/22.
 * 控制新建作业选择填空
 */
var choiceBum = 1;
var completionBum = 1;
var allChoiceValue = [];
var allCompletionValue = [];

function addChoice() {
    allChoiceValue.splice(0, allChoiceValue.length);//清空
    for (var i = 1; i < choiceBum; i++) {
        allChoiceValue.push(getChoiceValue(i, i));//保存原有内容
    }
    allChoiceValue.push(getChoiceValue(choiceBum, choiceBum));//添加新题
    document.getElementById("choices_field").innerHTML = allChoiceValue.toString();
    choiceBum++;
    for (i = 1; i < choiceBum; i++) {
        CKEDITOR.replace("choice-title_" + i);
    }

    var choices_field = $('.choices_field');
    choices_field.addClass('field-animation');
}
function addCompletion() {
    allCompletionValue.splice(0, allCompletionValue.length);//清空
    for (var i = 1; i < completionBum; i++) {
        allCompletionValue.push(getCompletionValue(i, i));//保存原有内容
    }
    allCompletionValue.push(getCompletionValue(completionBum, completionBum));
    completionBum++;
    document.getElementById("completions_field").innerHTML = allCompletionValue.toString();
    for (i = 1; i < completionBum; i++) {
        CKEDITOR.replace("question_content_" + i);
    }
}
function deleteChoice(index) {
    allChoiceValue.splice(0, allChoiceValue.length);
    var num = 1;
    for (var i = 1; i < choiceBum; i++) {//
        if (index !== i) {
            allChoiceValue.push(getChoiceValue(i, num));//保存原有内容
            num++;
        }
    }
    if (choiceBum > 1)
        choiceBum--;

    document.getElementById("choices_field").innerHTML = allChoiceValue.toString();
    for (i = 1; i < choiceBum; i++) {
        CKEDITOR.replace("choice-title_" + i);
    }
}
function deleteCompletion(index) {
    allCompletionValue.splice(0, allCompletionValue.length);
    var num = 1;
    for (var i = 1; i < completionBum; i++) {//
        if (index !== i) {
            allCompletionValue.push(getCompletionValue(i, num));//保存原有内容
            num++;
        }
    }
    if (completionBum > 1) {
        completionBum--;
    }
    document.getElementById("completions_field").innerHTML = allCompletionValue.toString();

    for (i = 1; i < completionBum; i++) {
        CKEDITOR.replace("question_content_" + i);
    }
}

function getChoiceValue(index, num) {
    //获取原始值
    var choiceTitleId = 'choice-title_' + index;

    var choiceQuestion, score;//题，分
    var s_A, s_B, s_C, s_D, ref_key;//选项，参考
    var ref_keyStringValue;
    if (index >= choiceBum) {
        choiceQuestion = '';
        score = '';
        s_A = '';
        s_B = '';
        s_C = '';
        s_D = '';
        ref_keyStringValue = getRefKeyString(num);//num!!!
        // ref_key = '';
    } else {
        choiceQuestion = CKEDITOR.instances[choiceTitleId].getData();
        score = document.getElementById('score_' + index).value;
        s_A = document.getElementById('choice_' + index + '_A').value;
        s_B = document.getElementById('choice_' + index + '_B').value;
        s_C = document.getElementById('choice_' + index + '_C').value;
        s_D = document.getElementById('choice_' + index + '_D').value;

        var refId='ref_key_'+index;
        ref_key = $("input[name="+refId+"][type='radio']:checked").val();

        ref_keyStringValue = getRefKeyString(num,ref_key);//ABCD选项
        // ref_key = document.getElementById('ref_key_' + index).value;
    }
    //获取参考答案


    //修改新标记值

    var ckediorString = '<textarea class="ckeditor" name="choice-title_' + num + '" ' +
        'id="choice-title_' + num + '">' + choiceQuestion + '</textarea>';

    var choiceFieldString;
    choiceFieldString = '<div class="choice_field" id="choice_field_' + num + '"><table width="100%"><tr>' +
        '<div class="title narrow">题目' + num + ':</div><div align="right" style="margin-bottom: 10px;">分数：<input class="score" id="score_' + num + '" name="score_' + num + '" type="text" value="' + score + '"></div><td colspan="4">' + ckediorString +
        '<a class="floatButton" onclick="deleteChoice(' + num + ')">删除</a></td></tr><tr><td class="narrow">选项A:</td><td><input class="choice" id="choice_' + num + '_A" type="text" name="choice_' + num + '_A" value="' + s_A + '" placeholder="选项A"></td><td class="narrow">选项B:</td>' +
        '<td><input class="choice" type="text" id="choice_' + num + '_B" name="choice_' + num + '_B"' +
        ' value="' + s_B + '" placeholder="选项B"></td></tr><tr><td class="narrow">选项C:</td><td><input class="choice" id="choice_' + num + '_C" type="text" name="choice_' + num + '_C" value="' + s_C + '" placeholder="选项C"></td>' +
        '<td class="narrow">选项D:</td><td><input class="choice" type="text" id="choice_' + num + '_D" name="choice_' + num + '_D" value="' + s_D + '" placeholder="选项D"></td> </tr> <tr> <td class="narrow">' +
        '参考答案:</td><td>'+ref_keyStringValue+'</td></tr> </table></div>';
    return choiceFieldString;
}

function getCompletionValue(index, num) {
    var id = 'question_content_' + index;
    var textContent;
    if (index >= completionBum) {
        textContent = ''
    } else {
        textContent = CKEDITOR.instances[id].getData();
    }

    var completionFieldString;
    completionFieldString = '<div class="completion_field">' +
        '<div class="title">问题' + num + ':</div><div style="float:right"><a class="floatButton" onclick="deleteCompletion(' + num + ')">删除</a></div><br><br><br>' +
        '<textarea class="ckeditor" name="question_content_' + num + '" ' +
        'id="question_content_' + num + '">' + textContent + '</textarea>' +
        '</div>';
    return completionFieldString;
}

function getRefKeyString(index,character) {
    var c_A = '',
        c_B = '',
        c_C = '',
        c_D = '';
    switch (character) {
        case 'A':
            c_A = 'checked'; break;
        case 'B':
            c_B = 'checked'; break;
        case 'C':
            c_C = 'checked'; break;
        case 'D':
            c_D = 'checked'; break;
        default: break;
    }
    var refKeyString;
    refKeyString = '<input type="radio" ' + c_A + ' name="ref_key_' + index + '"  value="A">A&nbsp' +
        '<input type="radio" ' + c_B + ' name="ref_key_' + index + '" value="B">B&nbsp' +
        '<input type="radio" ' + c_C + ' name="ref_key_' + index + '" value="C">C&nbsp' +
        '<input type="radio" ' + c_D + ' name="ref_key_' + index + '" value="D">D&nbsp';

    return refKeyString;
}