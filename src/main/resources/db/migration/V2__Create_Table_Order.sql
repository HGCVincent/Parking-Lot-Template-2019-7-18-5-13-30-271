create TABLE `order`(
    `id` int auto_increment primary key,
    `parkinglot_Id` int,
    `car_number` varchar(255),
    `start_time` TIMESTAMP,
    `end_time` timestamp ,
    `status` varchar(255),
    constraint `fk` foreign key (`parkinglot_Id`) references `parking_lot`(`id`)
)