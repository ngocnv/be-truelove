
SET search_path to trueloveapp;
CREATE TABLE trueloveapp.app_category_items (
	item_id UUID DEFAULT gen_random_uuid () NOT NULL PRIMARY KEY,
	category VARCHAR(30) NOT NULL,
	name VARCHAR(100) NOT NULL,
	addition_1 VARCHAR(500) ,
	addition_2 VARCHAR(500) ,
	addition_3 VARCHAR(500) ,
	description VARCHAR(100) NOT NULL,
	LANGUAGE VARCHAR (10) NOT NULL,
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_date TIMESTAMP
);

INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên quản lý rừng', 'nhân viên quản lý rừng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'cán bộ lâm nghiệp', 'cán bộ lâm nghiệp', 'VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà hoá sinh', 'nhà hoá sinh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên gia thực phẩm', 'chuyên gia thực phẩm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà di truyền học động vật', 'nhà di truyền học động vật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nông dân', 'nông dân','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chủ trại', 'chủ trại','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'tá điền', 'tá điền','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người chăn nuôi', 'người chăn nuôi','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà nghiên cứu động vật hoang dã', 'Nhà nghiên cứu động vật hoang dã','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người làm vườn', 'người làm vườn','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người giúp việc ở vườn ươm', 'người giúp việc ở vườn ươm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giáo viên nông nghiệp', 'giáo viên nông nghiệp','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà sinh vật học thực vật', 'nhà sinh vật học thực vật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'cán bộ thanh tra động vật hoang dã', 'cán bộ thanh tra động vật hoang dã','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'cán bộ thanh tra động vật hoang dã', 'cán bộ thanh tra động vật hoang dã','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà địa chất học', 'nhà địa chất học','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người nuôi ong', 'người nuôi ong','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà sinh thái học thuỷ sinh', 'nhà sinh thái học thuỷ sinh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà sinh thái học thuỷ sinh', 'nhà sinh thái học thuỷ sinh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà bảo tồn', 'nhà bảo tồn','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'thấy thuốc thú y', 'thấy thuốc thú y','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'thấy thuốc thú y', 'thấy thuốc thú y','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'bác sĩ thú y', 'bác sĩ thú y','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà động vật học', 'nhà động vật học','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà động vật học', 'nhà động vật học','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người cắt tỉa lông động vật', 'người cắt tỉa lông','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'cán bộ kiểm soát động vật', 'cán bộ kiểm soát động vật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người dắt thú cưng đi dạo', 'người dắt thú cưng đi dạo','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người trông giữ động vật', 'người trông giữ động vật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người quản lý nơi trú ẩn động vật', 'người quản lý nơi trú ẩn động vật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'trợ lý bác sĩ thú y', 'trợ lý bác sĩ thú y','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên gia dinh dưỡng động vật', 'chuyên gia dinh dưỡng động vật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà sinh vật học', 'nhà sinh vật học','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên cứu hộ động vật', 'nhân viên cứu hộ động vật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà bệnh học thú y', 'nhà bệnh học thú y','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'bác sĩ nhãn khoa thú y', 'bác sĩ nhãn khoa thú y','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'quản lý dự án', 'quản lý dự án','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'quản lý bán hàng', 'quản lý bán hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên viên định phí bảo hiểm', 'chuyên viên định phí bảo hiểm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên viên định phí bảo hiểm', 'chuyên viên định phí bảo hiểm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên viên', 'chuyên viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giảng viên', 'giảng viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giáo viên', 'giáo viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'phóng viên kinh doanh', 'phóng viên kinh doanh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'phóng viên', 'phóng viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người đại diện tuyển sinh', 'người đại diện tuyển sinh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'quản lý văn phòng', 'quản lý văn phòng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'thư ký văn phòng', 'thư ký văn phòng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên thu mua', 'nhân viên thu mua','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giám đốc phát triển kinh doanh', 'giám đốc phát triển kinh doanh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'quản lý phát triển kinh doanh', 'quản lý phát triển kinh doanh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giám đốc', 'giám đốc','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'quản lý salon', 'quản lý salon','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên trang điểm', 'nhân viên trang điểm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên gia trang điểm', 'chuyên gia trang điểm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'thợ nail', 'thợ nail','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên massage', 'nhân viên massage','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên cắt tóc', 'nhân viên cắt tóc','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên viên sắc đẹp', 'chuyên viên sắc đẹp','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên gia chăm sóc da', 'chuyên gia chăm sóc da','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà thiết kế thời trang', 'nhà thiết kế thời trang','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên gia thẩm mỹ', 'chuyên gia thẩm mỹ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giảng viên thẩm mỹ spa', 'giảng viên thẩm mỹ spa','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người tạo mẫu tóc', 'người tạo mẫu tóc','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà tạo mẫu biểu diễn thời trang', 'nhà tạo mẫu biểu diễn thời trang','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'quản lý spa', 'quản lý spa','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà tạo mẫu tiệc cưới', 'nhà tạo mẫu tiệc cưới','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên tổng đài', 'nhà tạo mẫu tiệc cưới','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'điều phối viên dịch vụ khách hàng', 'điều phối viên dịch vụ khách hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'đại diện hỗ trợ kỹ thuật', 'đại diện hỗ trợ kỹ thuật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'trợ lí ảo', 'trợ lí ảo','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên chăm sóc khách hàng', 'nhân viên chăm sóc khách hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'cộng tác viên bán lẻ', 'cộng tác viên bán lẻ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên thu ngân', 'nhân viên thu ngân','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên hỗ trợ dịch vụ khách hàng', 'nhân viên hỗ trợ dịch vụ khách hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhân viên hỗ trợ dịch vụ khách hàng', 'nhân viên hỗ trợ dịch vụ khách hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'quản lý dịch vụ khách hàng', 'quản lý dịch vụ khách hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên viên hỗ trợ', 'chuyên viên hỗ trợ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'điều phối viên tài khoản', 'điều phối viên tài khoản','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'cố vấn dịch vụ', 'cố vấn dịch vụ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giao dịch viên ngân hàng', 'giao dịch viên ngân hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'điều phôi viên lễ tân', 'điều phối viên lễ tân','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'điều phôi viên lễ tân', 'điều phối viên lễ tân','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'giám đốc nghệ thuật', 'giám đốc nghệ thuật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người thiết kế đồ họa', 'người thiết kế đồ hoạ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà văn', 'nhà văn','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'biên tập viên', 'biên tập viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'người vẽ tranh minh hoạ', 'người vẽ tranh minh hoạ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'chuyên gia quan hệ công chúng', 'chuyên gia quan hệ công chúng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'diễn viên', 'diễn viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'ca sĩ', 'ca sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà sản xuất', 'nhà sản xuất','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'nhà phát triển web', 'nhà phát triển web','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE', 'kiến trúc sư', 'kiến trúc sư','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','người làm phim hoạt hình đa phương tiện', 'người làm phim hoạt hình đa phương tiện','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','hoạ sĩ', 'hoạ sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','thợ xăm', 'thợ xăm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà thiết kế hoa', 'nhà thiết kế hoa','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giáo viên tiếng Anh', 'giáo viên tiếng Anh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giáo sư', 'giáo sư','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','gia sư', 'gia sư','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','người chấm bài kiểm tra', 'người chấm bài kiểm tra','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý viên kiểm tra', 'quản trị viên kiểm tra','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trợ giảng', 'trợ giảng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','hiệu trưởng', 'hiệu trưởng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám thị', 'giám thị','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','phó hiệu trưởng', 'phó hiệu trưởng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','thủ thư', 'thủ thư','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giáo viên dạy toán', 'giáo viên dạy toán','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giáo viên dạy môn tự nhiên', 'giáo viên tự nhiên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giáo viên dạy môn xã hội', 'giáo viên xã hội','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','thiết kế giảng dạy', 'thiết kế giảng dạy','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','hướng dẫn và tư vấn', 'hướng dẫn và tư vấn','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư xây dựng', 'kĩ sư xây dựng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư xây dựng', 'kĩ sư xây dựng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư cơ khí', 'kĩ sư cơ khí','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư hoá', 'kĩ sư hoá','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư sinh học', 'kĩ sư sinh học','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư hoá sinh', 'kĩ sư hoá sinh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư hạt nhân', 'kĩ sư hạt nhân','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư hàng không vũ trụ', 'kĩ sư hàng không vũ trụ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư điện', 'kĩ sư điện','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư môi trường', 'kĩ sư môi trường','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư địa chất', 'kĩ sư địa chất','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư hàng hải', 'kĩ sư hàng hải','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư dầu khí', 'kĩ sư dầu khí','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư sức khỏe và an toàn', 'kĩ sư sức khỏe và an toàn','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư sản phẩm', 'kĩ sư sản phẩm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư tuân thủ', 'kĩ sư tuân thủ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư quy trình cao cấp', 'kĩ sư quy trình cao cấp','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư', 'kĩ sư','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên cao cấp', 'chuyên viên cao cấp','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà hoạch định tài chính', 'nhà hoạch định tài chính','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên tư vấn tài chính', 'chuyên viên tư vấn tài chính','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên gia phân tích ngân sách', 'chuyên gia phân tích ngân sách','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên gia phân tích tín dụng', 'chuyên gia phân tích tín dụng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên gia tài chính', 'chuyên gia tài chính','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','người đại diện dịch vụ tài chính', 'người đại diện dịch vụ tài chính','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý tài chính', 'quản lý tài chính','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên dự toán chi phí', 'chuyên viên dự toán chi phí','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên tín dụng', 'chuyên viên tín dụng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phân tích đầu tư', 'nhà phân tích đầu tư','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kiểm toán viên', 'kiểm toán viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc tài chính', 'giám đốc tài chính','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','y tá', 'y tá','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','bác sĩ', 'bác sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhân viên điều dưỡng', 'nhân viên điều dưỡng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà vật lý trị liệu', 'nhà vật lý trị liệu','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','huấn luân viên cá nhân', 'huấn luân viên cá nhân','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','dược sĩ', 'dược sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trợ lý dược sĩ', 'trợ lý dược sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','vệ sinh nha khoa ', 'vệ sinh nha khoa','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','Bác sĩ chỉnh răng', 'Bác sĩ chỉnh răng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','Bác sĩ chỉnh răng', 'Bác sĩ chỉnh răng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trợ lý nha sĩ', 'trợ lý nha sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nha sĩ', 'nha sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ thuật viên phẫu thuật', 'kĩ thuật viên phẫu thuật','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên gia dinh dưỡng', 'chuyên gia dinh dưỡng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','tiến sĩ', 'tiến sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','thạc sĩ', 'thạc sĩ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','phó giáo sư', 'phó giáo sư','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','đại lý du lịch', 'đại lý du lịch','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','người quản gia', 'người giản gia','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','người khuân vác (porter)', 'người khuân vác (porter)','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chủ sòng bạc', 'chủ sòng bạc','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhân viên khách sạn', 'nhân viên khách sạn','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhân viên lập kế hoạch tổ chức cuộc họp', 'nhân viên lập kế hoạch tổ chức cuộc họp','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhân viên', 'nhân viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','bếp trưởng', 'bếp trưởng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','hướng dẫn viên du lịch', 'hướng dẫn viên du lịch','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','tiếp viên hàng không', 'tiếp viên hàng không','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý sự kiện', 'quản lý sự kiện','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý nguồn nhân lực', 'quản lý nguồn nhân lực','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý nguồn nhân lực', 'quản lý nguồn nhân lực','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý C&B', 'quản lý C&B','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trợ lý hành chính', 'trợ lý hành chính','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','HR generalist ', 'HR generalist','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','điều phối viên thu nhận nhân tài', 'điều phối viên thu nhận nhân tài','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc tuyển dụng', 'giám đốc tuyển dụng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc tuyển dụng', 'giám đốc tuyển dụng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên nhân sự', 'chuyên viên nhân sự','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trợ lý nhân sự', 'trợ lý nhân sự','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trợ lý', 'trợ lý','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên quan hệ lao động', 'chuyên viên quan hệ lao động','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên gia tư vấn nguồn nhân lực', 'chuyên gia tư vấn nguồn nhân lực','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','người liên kết nguồn nhân lực quốc tế', 'người liên kết nguồn nhân lực quốc tế','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý hệ thống nguồn nhân lực', 'quản lý hệ thống nguồn nhân lực','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','cố vấn bồi thường', 'cố vấn bồi thường','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','cố vấn bồi thường', 'cố vấn bồi thường','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','tư vấn viên', 'tư vấn viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc đào tạo và phát triển', 'giám đốc đào tạo và phát triển','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc đào tạo và phát triển', 'giám đốc đào tạo và phát triển','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','thiết kế UX', 'thiết kế UX','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','thiết kế', 'thiết kế','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phát triển giao diện người dùng', 'phát triển giao diện người dùng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý công nghệ thông tin', 'quản lý công nghệ thông tin','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','lập trình viên', 'lập trình viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phát triển phần mềm', 'phát triển phần mềm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản trị viên web', 'quản trị viên web','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kiến trúc dữ liệu', 'kiến trúc dữ liệu','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phát triển trí tuệ doanh nghiệp', 'phát triển trí tuệ doanh nghiệp','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phát triển ứng dụng di động', 'phát triển ứng dụng di động','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phân tích an toàn thông tin', 'phân tích an toàn thông tin','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phân tích', 'nhà phân tích','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phát triển web frontend', 'nhà phát triển web frontend','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà phát triển java', 'nhà phát triển java','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý cơ sở dữ liệu', 'quản lý cơ sở dữ liệu','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư phần mềm', 'kĩ sư phần mềm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','kĩ sư phần mềm', 'kĩ sư phần mềm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc điều hành', 'giám đốc điều hành','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trưởng nhóm', 'trưởng nhóm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trưởng nhóm', 'trưởng nhóm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý', 'quản lý','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám sát', 'giám sát','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chủ tịch', 'chủ tịch','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','phó chủ tịch', 'phó chủ tịch','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','điều phối viên', 'điều phối viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý sản phẩm', 'quản lý sản phẩm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc sáng tạo', 'giám đốc sáng tạo','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản  truyền thông xã hội', 'quản  truyền thông xã hội','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý nhãn hàng', 'quản lý nhãn hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc tiếp thị nội dung', 'giám đốc tiếp thị nội dung','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','phân tích marketing', 'phân tích marketing','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','tư vấn marketing', 'tư vấn marketing','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên tối ưu với search engine', 'chuyên viên tối ưu search engine','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','đại diện bán hàng', 'đại diện bán hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc kinh doanh', 'giám đốc kinh doanh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý kinh doanh', 'quản lý kinh doanh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','đại lý bán bảo hiểm', 'đại lý bán bảo hiểm','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','điện thoại viên', 'điện thoại viên','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhà bán lẻ', 'nhà bán lẻ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý cửa hàng', 'quản lý cửa hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chuyên viên kinh doanh B2', 'chuyên viên kinh doanh B2','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','điều hành tài khoản', 'điều hành tài khoản','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','phân tích kinh doanh', 'phân tích kinh doanh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','môi giới bất động sản', 'môi giới bất động sản','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','nhân viên bán hàng', 'nhân viên bán hàng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','tư vấn kinh doanh', 'tư vấn kinh doanh','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','dịch vụ thu nợ', 'dich vụ thu nợ','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám đốc bán hàng khu vực', 'giám đốc bán hàng khu vực','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','điều phối viên xuất nhập khẩu', 'điều phối viên xuất nhập khẩu','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám sát kho', 'giám sát kho','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý chuỗi cung cấp', 'quản lý chuỗi cung cấp','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám sát phân phối', 'giám sát phân phối','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','giám sát phân phối', 'giám sát phân phối','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','điều phối viên chuỗi cung ứng', 'điều phối viên chuỗi cung ứng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','điều phối viên chuỗi cung ứng', 'điều phối viên chuỗi cung ứng','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','trợ lý vận hành', 'trợ lý vận hành','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chỉ huy cải tiến quá trình liên tục', 'chỉ huy cải tiến quá trình liên tục','VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','quản lý vận hành','quản lý vận hành' ,'VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','chỉ huy','chỉ huy' ,'VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','tự do','tự do' ,'VN', '2021-04-29 11:02:18.880674', NULL);
INSERT INTO "trueloveapp"."app_category_items" ( "category", "name", "description", "language","created_date", "modified_date") VALUES
('JOB_TITLE','doanh nhân','doanh nhân' ,'VN', '2021-04-29 11:02:18.880674', NULL);