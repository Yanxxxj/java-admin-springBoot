import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/table/list',
    method: 'get',
    params
  })
}

// 查询用户列表
export function listUser(query) {
  return request({
    url: '/test/user/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getUser(id) {
  return request({
    url: '/test/user/' + id,
    method: 'get'
  })
}

// 新增
export function addUser(data) {
  return request({
    url: '/test/user',
    method: 'post',
    data: data
  })
}

// 修改
export function updateUser(data) {
  return request({
    url: '/test/user',
    method: 'put',
    data: data
  })
}

// 删除
export function delUser(id) {
  return request({
    url: '/test/user/' + id,
    method: 'delete'
  })
}
